public class StringPayloadConversion {

    public static String getPayload(String place_id)
    {
        return "{ \n" +
                "\"place_id\":\""+place_id+"\",\n" +
                "\"address\":\"9000 kamakshipalya winter walk, Aus\",\n" +
                "\"key\":\"qaclick123\",\n" +
                "\"types\": \"pen shop\"\n" +
                "}";
    }
}
