package com.example.demo.HelperUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;
@Component
public class HelperFunction {

    @Autowired
    private CacheManager cacheManager;

    public void removeCacheEntry(String cacheName, Object cacheKey) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache != null) {
            cache.evict(cacheKey);
        }
    }
    
    
    //for capitalize first character of letter 
public String capitalizeFirstLetter(String str) {
	    if(str != null && !str.isEmpty())
        {
            return Character.toUpperCase(str.charAt(0)) + str.substring(1).toLowerCase();

        }else
        {
            return "";
        }
	}
    
    
    public void removeCacheEntry(String cacheName, Integer Lobid) {       
        Cache cache = cacheManager.getCache(cacheName);
        if (cache != null) {
            cache.evict(Lobid);
        }
    }
    
    //for capitalize first letter of each field
    public static String capitalizeFirstLetterOfEachWord(String input) {
        StringBuilder output = new StringBuilder();
        boolean capitalizeNext = true;
        for (char c : input.toCharArray()) {
            if (Character.isWhitespace(c)) {
                capitalizeNext = true;
                output.append(c);
            } else if (capitalizeNext) {
                output.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }
    
    
}

