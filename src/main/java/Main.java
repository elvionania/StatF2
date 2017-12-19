

    import org.enania.chessstats.utils.HttpUtils;

    public class Main {

        public static void main(String[] args) throws Exception {

            HttpUtils hu = new HttpUtils();
            String url1 = "https://www.whoscored.com/";

            String c1 = hu.getResponse(url1);

            int index1 = c1.indexOf("Spain-La-Liga");
            String sst1 = c1.substring(0, index1);
            int index2 = sst1.lastIndexOf('"');
            String url2 = "https://www.whoscored.com" + c1.substring(index2 + 1, index1) + "Spain-La_Liga";


            System.out.println(hu.getResponse(url2));
        }
    }
