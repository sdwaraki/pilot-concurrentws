package com.sumanth.projects.pilotconcurrentws.rest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.sumanth.projects.pilotconcurrentws.model.Article;

import freemarker.template.SimpleDate;

public class NewsAPIDeserializer extends StdDeserializer<NewsAPIResponse> {
	
	public NewsAPIDeserializer() {
		this(null);
	}

	  public NewsAPIDeserializer(Class<?> vc) { 
	        super(vc); 
	    }
	
	  public NewsAPIResponse deserialize(JsonParser jp, DeserializationContext ctxt) 
			throws IOException, JsonProcessingException {
		JsonNode node = jp.getCodec().readTree(jp);
		String status = null;
		if (node.get("status") != null) {
			status = node.get("status").asText();
		}

		Integer totalRes = null;
		if (node.get("totalResults") != null) {
			totalRes = node.get("totalResults").asInt();
		}
		Article[] a = null;
		if (node.get("articles") != null) {
			ArrayNode aNode = (ArrayNode) node.get("articles");
			Iterator it = aNode.iterator();
			int s = aNode.size();
			a = new Article[s];
			int i = 0;
			while (it.hasNext()) {
				JsonNode p = (JsonNode) it.next();
				Article ar = new Article();
				if (p.get("author") != null) {
					ar.setAuthor(p.get("author").asText());
				}
				if (p.get("description") != null) {
					ar.setDescription(p.get("description").asText());
				}
				if (p.get("title") != null) {
					ar.setTitle(p.get("title").asText());
				}
				if (p.get("url") != null) {
					ar.setUrl(p.get("url").asText());
				}
				if (p.get("urlToImage") != null) {
					ar.setUrlToImage(p.get("urlToImage").asText());
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:s'Z'");
				if (p.get("publishedAt") != null) {
					try {
						ar.setPublishedAt(format.parse(p.get("publishedAt").textValue()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				a[i++] = ar;
			}
		}
		NewsAPIResponse response = new NewsAPIResponse();
		response.setArticles(a);
		response.setSt(status);
		response.setTotalResults(totalRes);
		return response;
	}

}
