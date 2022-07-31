package com.spring.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class httpConnection {

	public static final String ENCODING = "UTF-8";

	private httpConnection(){}
	
	private static class httpConnection_Singieton{
		private static final httpConnection instance = new httpConnection();
	}
	
	public static httpConnection getInstance(){
		return httpConnection_Singieton.instance;
	}
	
	//get諛⑹떇 rest �샇異쒖떆 �궗�슜
	public StringBuffer HttpGetConnection(String apiURL) throws IOException {
		StringBuffer response = new StringBuffer();

        URL url = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        
        return responseHttp(con);
	}
	
	//get諛⑹떇 rest �샇異쒖떆 �궗�슜
	public StringBuffer HttpGetConnection(String apiURL, Map<String, String> header) throws IOException {
		StringBuffer response = new StringBuffer();

        URL url = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");

	      //留뚯빟�뿉 �뙆�씪硫뷀꽣�뿉 Authorization媛� �엳�떎硫� �뿤�뜑濡� 異붽� �썑 params�뿉�꽌 �젣嫄�
	      if(header.get("Authorization") != null) {
	    	  con.setRequestProperty("Authorization", header.get("Authorization"));
	    	  header.remove("Authorization");
	      }
        
        return responseHttp(con);
	}
	
	//post諛⑹떇 rest �샇異쒖떆 �궗�슜
	public StringBuffer HttpPostConnection(String apiURL, Map<String, String> params) throws IOException {
	      URL url = new URL(apiURL);
	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
	      con.setRequestMethod("POST");
	      con.setDoOutput(true);
	      
	      //留뚯빟�뿉 �뙆�씪硫뷀꽣�뿉 Authorization媛� �엳�떎硫� �뿤�뜑濡� 異붽� �썑 params�뿉�꽌 �젣嫄�
	      if(params.get("Authorization") != null) {
	    	  con.setRequestProperty("Authorization", params.get("Authorization"));
	    	  params.remove("Authorization");
	      }
	      
	      // post request
	      // �빐�떦 string�� UTF-8濡� encode �썑 MS949濡� �옱 encode瑜� �닔�뻾�븳 媛�
	      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
          StringBuilder sb = new StringBuilder();
          
          int amp = 0;
          for( String key : params.keySet() ){
        	  //2踰덉㎏ �뙆�씪硫뷀꽣遺��꽣�뒗 援щ텇�옄 &媛� �엳�뼱�빞�븳�떎.
        	  if(amp >= 1) sb.append("&"); amp+=1; 
        	  
        	  sb.append(key+params.get(key));
        	     
          }
          
          System.out.println("파라미터 : " + sb.toString());
          
          bw.write(sb.toString());
          bw.flush();
	      bw.close();
          
	      return responseHttp(con);
	}
	
	//�꽌踰꾩뿉 �슂泥��븯�뒗 硫붿냼�뱶
	public StringBuffer responseHttp(HttpURLConnection con) throws IOException {
		StringBuffer response = new StringBuffer();
		
	    int responseCode = con.getResponseCode();
	    BufferedReader br;
	    if(responseCode==200) { // �젙�긽 �샇異�
	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    } else {  // �뿉�윭 諛쒖깮
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	    }
	      
	    String inputLine;
	    while ((inputLine = br.readLine()) != null) {
	        response.append(inputLine);
	    }
	    br.close();
	    
	    return response;
	}
	
	//�뙆�씪硫뷀꽣 URL �씤肄붾뵫
	public String URLencoder(String contents) throws UnsupportedEncodingException {
		return URLEncoder.encode(URLEncoder.encode(contents, ENCODING), "MS949");
	}
	
}