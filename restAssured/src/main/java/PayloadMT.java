public class PayloadMT {
    public static String getPrice(String products[]) {
        String xmlWithMultipleItems =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                        "<ns2:CustomerPrices_Req xmlns:ns2=\"urn:mt.com:C:MDM:DataTypes\">\n" +
                        "  <HEADER>\n" +
                        "    <CURRENCY>USD</CURRENCY>\n" +
                        "    <SOLDTO>301079906</SOLDTO>\n" +
                        "    <SALESORGANIZATION>O 20000875</SALESORGANIZATION>\n" +
                        "    <DISTRIBUTIONCHANNEL>20</DISTRIBUTIONCHANNEL>\n" +
                        "    <DIVISION>10</DIVISION>\n" +
                        "    <PRICINGPROCEDURE>ZMTBO8</PRICINGPROCEDURE>\n" +
                        "  </HEADER>\n";
        for (int i = 0; i < products.length; i = i + 1) {
            xmlWithMultipleItems +="  <ITEM>\n" +
                    "    <PRODUCT>" + products[i] + "</PRODUCT>\n" +
                    "    <QTY>1</QTY>\n" +
                    "    <UNITMEASURE>EA</UNITMEASURE>\n" +
                    "    <ITEMID>1</ITEMID>\n" +
                    "  </ITEM>\n";
        }
        xmlWithMultipleItems += "</ns2:CustomerPrices_Req>";
        return xmlWithMultipleItems;
    }

}
// "    <ITEM>\n" +
//         "    <PRODUCT>"+result+"</PRODUCT>\n" +
//         "    <QTY>1</QTY>\n" +
//         "    <UNITMEASURE>EA</UNITMEASURE>\n" +
//         "    <ITEMID>1</ITEMID>\n" +
//         "  </ITEM>\n" +
//         "</ns2:CustomerPrices_Req>";