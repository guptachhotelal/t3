package com.t3.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class T3Controller {

    @RequestMapping(value = "topper.htm")
    public String showForm(HttpServletRequest request, HttpServletResponse response, Model model) {
        String testURL = request.getParameter("testURL");
        String num = request.getParameter("num");
        if (null == num || "".equals(num) || "0".equals(num)) {
            model.addAttribute("num", 0);
            return "topper";
        }
        try {
            Connection.Response resp = Jsoup.connect(testURL).method(Method.GET).ignoreContentType(true).maxBodySize(0).timeout(0).execute();
            String body = resp.body();
//            byte[] bytes = Files.readAllBytes(Paths.get("C:\\Users\\chhotelal.gupta\\Desktop\\t3test.txt"));
//            String body = new String(bytes, StandardCharsets.UTF_8);
            List<String> list = Arrays.asList(body.split("\\s+"));
            Set<String> set = new HashSet<>(list);
            Map<String, Integer> freqMap = new HashMap<>();
            set.forEach(word -> {
                freqMap.put(word, Collections.frequency(list, word));
            });
            Map<String, Integer> sortedMap = freqMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue(Collections.reverseOrder()).thenComparing(Map.Entry.<String, Integer>comparingByKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            Map<String, Integer> viewMap = new LinkedHashMap<>();
            sortedMap.keySet().stream().limit(Integer.parseInt(num)).forEach((key) -> {
                viewMap.put(key, sortedMap.get(key));
            });
            model.addAttribute("viewMap", viewMap);
        } catch (IOException e) {
            Map<String, String> viewMap = new HashMap<>();
            viewMap.put("Error Message", e.getMessage());
        }
        model.addAttribute("num", num);
        return "topper";
    }
}
