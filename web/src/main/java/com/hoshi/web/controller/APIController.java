package com.hoshi.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.hoshi.web.util.Util;

@Controller
public class APIController {
	
	@Autowired
	private Util util;

	@GetMapping("/airKorea")
	public String airKorea(Model model) throws IOException, ParseException {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth");
		urlBuilder.append("?serviceKey="+util.getServiceKey());
		urlBuilder.append("&returnType=json");
		urlBuilder.append("&numOfRows=100");
		urlBuilder.append("&pageNo=1");
		urlBuilder.append("&searchDate=2024-03-12");
		urlBuilder.append("&InformCode=PM10");
		
		
		URL url = new URL(urlBuilder.toString()); 
		HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("응답 결과 : "+conn.getResponseCode());//200 나오면 정상
		  
		BufferedReader rd; 
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <=300) { 
		 rd = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
		} else { 
		 rd = new BufferedReader(new InputStreamReader(conn.getErrorStream())); 
		}
		  
		StringBuilder sb = new StringBuilder(); String line;
		while((line=rd.readLine()) != null) { System.out.println("챠라");
		sb.append(line); }
		  
		rd.close(); conn.disconnect(); System.out.println(sb.toString());
		 
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(url.openStream()));
		System.out.println(jsonObject.toString());
		
		Map<String, Object> map = (Map<String, Object>) jsonObject.get("response");
		map = (Map<String, Object>) map.get("body");
		JSONArray jsonArray = (JSONArray) map.get("items");
		
		model.addAttribute("data",jsonArray);
		
		return "airkorea"; // 반드시 URL과 같을 필요가 없습니다.
	}
	
	@GetMapping("/airKoreaXML")
	public String airKoreaXML(Model model) throws IOException, ParserConfigurationException, SAXException {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth");
		urlBuilder.append("?serviceKey="+util.getServiceKey());
		urlBuilder.append("&returnType=xml");
		urlBuilder.append("&numOfRows=100");
		urlBuilder.append("&pageNo=1");
		urlBuilder.append("&searchDate=2024-03-12");
		urlBuilder.append("&InformCode=PM10");
		
		
		URL url = new URL(urlBuilder.toString()); 
		HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("응답 결과 : "+conn.getResponseCode());//200 나오면 정상
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		//Document document = documentBuilder.parse(conn.getInputStream());
		Document document = documentBuilder.parse(conn.getInputStream());
		document.getDocumentElement().normalize();
		
		System.out.println("response : " + document.getDocumentElement().getNodeName()); //node nodeName == DOM
		
		NodeList list = (NodeList) document.getDocumentElement().getChildNodes().item(3);//body
		System.out.println(list.getLength());
		System.out.println(list.item(1).getNodeName());//items
		
		NodeList list2 = list.item(1).getChildNodes();//items
		//System.out.println("items :: " + list2.getLength());
		//System.out.println("items :: " + list2.item(0).getNodeName());
		
		List<Map<String, String>> data = new ArrayList<Map<String,String>>();
		for (int i = 1; i < list2.getLength();  i++) {
			NodeList list3 = list2.item(i).getChildNodes();//item == 13개
			for (int j = 1; j < list3.getLength(); j++) {
				Node node = list3.item(j);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Map<String, String> map = new HashMap<String, String>();
					//System.out.println(j + "_Key : " + list3.item(j).getNodeName());
					//System.out.println(j + "_Val : " + list3.item(j).getTextContent());
					if(list3.item(j).getTextContent()!="") {
						map.put(list3.item(j).getNodeName(), list3.item(j).getTextContent());
						data.add(map);
					}
				}
			}
		}
		model.addAttribute("data",data);
		return "airkoreaXML"; // 반드시 URL과 같을 필요가 없습니다.
	}
	
	@GetMapping("/html")
	public String html() throws IOException {
		org.jsoup.nodes.Document doc = Jsoup.connect("https://www.clien.net/service/").get();
		
		Elements element = doc.select(".somoim > .menu_over");
		
		System.out.println(element.size());
		
		for (Element ele : element) {
			System.out.println(ele.text());
		}
		return "html";
	}

}
