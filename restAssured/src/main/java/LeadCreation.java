import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class LeadCreation {
    public static void main(String[] args) {

RestAssured.baseURI="https://qas-us-partner.store.mt.com";


//CreateCustomer
        String cookie="dtCookie=v_4_srv_1_sn_5579B0932B40460A286EEAA4F07F685A_perc_100000_ol_0_mul_1_app-3A7b650ffacc0b8e1f_1; ROUTEID=.1; cookiesession1=678B28B0BFCAE937E489596C86990C57; rxVisitor=16737184126910QGLATMBLK1HO1CBUDLJM2A2HK593KJM; MTMO_US_DP_Store_CookiePolicy=true; BETA_MTMO_US_DP_Site-cart=1c7e0150-22c4-4ce1-92c6-354da6d5f9ee; JSESSIONID=20801D08588FFD2E9966514A7DE2CC58; remember-me=V2dMMnZwVmRwRm5iQWVTMlNRcWVMQSUzRCUzRDpwS3JFbUVCdDNxUkt5NHFndmVrVXRnJTNEJTNE; acceleratorSecureGUID=a80a0237dd588a729f4f19282339be0348818f45; rxvt=1673728843796|1673718412693; dtPC=$327043359_335h-vSKRTCKPTKVPTJNKCFSOOFUHEJHSRKELW-0e0; dtLatC=1; dtSa=true%7CC%7C-1%7Csubmit%7C-%7C1673727109866%7C327039369_197%7Chttps%3A%2F%2Fqas-us-partner.store.mt.com%2FcreateLead%7C%7C%7C%7C";
        String cookieLead="dtCookie=v_4_srv_1_sn_5579B0932B40460A286EEAA4F07F685A_perc_100000_ol_0_mul_1_app-3A7b650ffacc0b8e1f_1; ROUTEID=.1; cookiesession1=678B28B0BFCAE937E489596C86990C57; rxVisitor=16737184126910QGLATMBLK1HO1CBUDLJM2A2HK593KJM; MTMO_US_DP_Store_CookiePolicy=true; BETA_MTMO_US_DP_Site-cart=1c7e0150-22c4-4ce1-92c6-354da6d5f9ee; JSESSIONID=20801D08588FFD2E9966514A7DE2CC58; remember-me=V2dMMnZwVmRwRm5iQWVTMlNRcWVMQSUzRCUzRDpwS3JFbUVCdDNxUkt5NHFndmVrVXRnJTNEJTNE; acceleratorSecureGUID=a80a0237dd588a729f4f19282339be0348818f45; dtLatC=4; rxvt=1673729328391|1673718412693; dtPC=$327527897_155h-vSKRTCKPTKVPTJNKCFSOOFUHEJHSRKELW-0e0; dtSa=true%7CC%7C-1%7CNew%20lead%7C-%7C1673727538266%7C327527897_155%7Chttps%3A%2F%2Fqas-us-partner.store.mt.com%2FcreateLead%2FcustomerInfo%3FcompanyName1%3Dtest%26companyName2%3Dtest%26addressLine1%3Dtester%26addressLine2%3D%26industryLevel1%3D1013%26industryLevel2%3D2078%26city%3Dhhgg%26state%3DCA%26postalCode%3D55455%26country%3DUS%26language%3Den_5FUS%26title%3Dprofile_5FuserTitle_5FMr%26firstName%3Dhhghj%26contactLanguage%3Den_5FUS%26lastName%3Dhjkk%26workplace%3DGLIQ%26email%3Dsingle.3acnt_2540gmail.com%26phoneNumber%3D0123456789%26CSRFToken%3D4c4ffa65-b23a-428a-954d-10bf5de59c9c%7C%7C%7C%7C";
        String CSRFtoken="bbf80242-8546-46ea-b605-88984ca58d66";


given().log().all().queryParam("companyName1", "Sixsentix")
        .queryParam("companyName2", "Firma")
        .queryParam("addressLine1","Milutina Milankovica")
        .queryParams("addressLine2","Sabacka")
        .queryParam("industryLevel1","1004")
        .queryParam("industryLevel2","2008")
        .queryParam("city", "Belgrade")
        .queryParam("state", "DE")
        .queryParam("postalCode", "12345")
        .queryParam("country", "US")
        .queryParam("language", "en_US")
        .queryParam("firstName", "Bojana")
        .queryParam("contactLanguage", "en_US")
        .queryParam("lastName", "Trifunovic")
        .queryParam("workplace", "IT")
        .queryParam("email", "single.10acnt@gmail.com")
        .queryParam("phoneNumber", "123456789693")
        .queryParam("CSRFToken",CSRFtoken)
        .header("Cookie", cookie)
        .when().get("/createLead/customerInfo")
        .then().log().all().assertThat().statusCode(200);

//CreateLead
        given().log().all().contentType("multipart/form-data")
                .multiPart("description", "Deskripcija")
                .multiPart("qualificationLevel", "Hot")
                .multiPart("sbu", "AU")
                .multiPart("territoryKey", "LAB_SOL")
                .multiPart("assignTo", "502952536")
                .multiPart("isEmailSendToLeadMan", "on")
                .multiPart("notes", "bl bla")
                .multiPart("CSRFToken", CSRFtoken)
                .header("Cookie", cookieLead)
                .when().post("/createLead/lead-details")
                .then().log().all().assertThat().statusCode(200);


    }
}