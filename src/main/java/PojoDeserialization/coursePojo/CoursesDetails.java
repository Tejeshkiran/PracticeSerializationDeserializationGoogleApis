package PojoDeserialization.coursePojo;

import java.util.List;

public class CoursesDetails {

    private List<webAutomation> webAutomation;
    private List<api> api;
    private List<mobile> mobile;

    public List<PojoDeserialization.coursePojo.webAutomation> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<PojoDeserialization.coursePojo.webAutomation> webAutomation) {
        this.webAutomation = webAutomation;
    }

    public List<PojoDeserialization.coursePojo.api> getApi() {
        return api;
    }

    public void setApi(List<PojoDeserialization.coursePojo.api> api) {
        this.api = api;
    }

    public List<PojoDeserialization.coursePojo.mobile> getMobile() {
        return mobile;
    }

    public void setMobile(List<PojoDeserialization.coursePojo.mobile> mobile) {
        this.mobile = mobile;
    }
}
