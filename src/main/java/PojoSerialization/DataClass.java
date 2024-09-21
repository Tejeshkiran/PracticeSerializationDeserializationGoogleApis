package PojoSerialization;

import java.util.ArrayList;

public class DataClass {

    public static PojoMapAddress getPojoSerializationObject()
    {
        PojoMapLocation pml = new PojoMapLocation();
        pml.setLat("-38.383494");
        pml.setLng("33.427362");
        PojoMapAddress pma = new PojoMapAddress();
        pma.setAccuracy(50);
        pma.setPhone_number("(+91) 983 893 3937");
        pma.setAddress("29, side layout, cohen 09");
        pma.setWebsite("http://google.com");
        pma.setLanguage("French-IN");
        pma.setLocation(pml);
        pma.setName("Rahul");
        ArrayList<String> ary = new ArrayList<String>();
        ary.add("shoe park");
        ary.add("shop");
        pma.setTypes(ary);
        return pma;

    }
}
