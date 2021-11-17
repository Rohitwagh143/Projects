package Deserlization_Pojo.Pojo.SubPojo;

import java.util.List;

public class courses {
    private List<Deserlization_Pojo.Pojo.SubPojo.mobile> mobile;
    private List<webAutomation> WebAutomation;
    private List<api> API;

    public List<Deserlization_Pojo.Pojo.SubPojo.mobile> getMobile() {
        return mobile;
    }

    public void setMobile(List<Deserlization_Pojo.Pojo.SubPojo.mobile> mobile) {
        this.mobile = mobile;
    }

    public List<webAutomation> getWebAutomation() {
        return WebAutomation;
    }

    public void setWebAutomation(List<webAutomation> webAutomation) {
        WebAutomation = webAutomation;
    }

    public List<api> getAPI() {
        return API;
    }

    public void setAPI(List<api> API) {
        this.API = API;
    }
}
