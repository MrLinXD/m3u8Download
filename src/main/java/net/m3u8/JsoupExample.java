package net.m3u8;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//@Slf4j
public class JsoupExample {
    public static void main(String[] args) {
        try {
            // 使用Jsoup连接到指定的网址，并获取HTML内容
            Document doc = Jsoup.connect("https://51cg.fun").get();

            System.out.println(doc.outerHtml());
            // 通过选择器语法查找具体的元素
            Elements titles = doc.select("h1");  // 查找所有<h1>元素
            Element title = titles.first();  // 获取第一个<h1>元素
            System.out.println("Title: " + title.text());

            Elements links = doc.select("a");  // 查找所有<a>元素
            for (Element link : links) {
                String href = link.attr("href");  // 获取<a>元素的href属性值
                String text = link.text();  // 获取<a>元素的文本内容
                System.out.println("Link: " + text + " - " + href);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
