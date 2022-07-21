package browser;

import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.swing.text.html.HTML;
import java.io.IOException;

public class JsoupTest {

    public static HTML start() throws IOException {

        HTML result = null;

        /**
         Document doc = Jsoup.connect("https://online.sberbank.ru/CSAFront/index.do#/service?srvUrl=/sbtsbol/private/brokerage%23/management&from=websbinvestor%26_ga=2.66146542.1115496698.1606129540-1447269435.1606129540%26_gac=1.45918806.1606129568.CjwKCAiA2O39BRBjEiwApB2IkmgD5wkiSpcoGZXhI3aQ-d5Npd-qLuplBXONZ6eW7sRckPkiXphS7RoCHXEQAvD_BwE")
         .userAgent("Chrome/4.0.249.0 Safari/532.5")
         .referrer("http://www.google.com")
         .get();
         System.out.println(doc.toString());
         */

        Document doc = Jsoup.connect("https://www.google.ru/")
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();

        // Пример поиска элемента(google кнопка войти):
        Elements els = doc.select("a");
        for(int i =0; i < els.size(); i++){
            Element el = els.get(i);
            if(el.id().equals("gb_70")) {
                String link = el.attr("href");
                System.out.println(link);
                System.out.println(el);

                W3CDom w3cDom = new W3CDom();
                org.w3c.dom.Document w3cDoc = w3cDom.fromJsoup(el);


                //result = (HTML)el.toString());
                return result;
            }
        }

        return result;

    }

    /**
     * При первом запуске получаем/запоминаем все обьявления на странице:
     */
    public void initializePage(){
        //List<WebElement> allElementOrder = findAllOrder();

        //for (int i = 0; i < allElementOrder.size(); i++ ){
        //WebElement nextElement = allElementOrder.get(i);
        //String nextKey = generateOrderInfo(nextElement.getText());
        //addNewOrder(nextKey);
        //}
    }

    public static void main(String[] args) throws IOException {
        start();
    }

}
