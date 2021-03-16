package test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2021/2/26
 */
public class TestErp {

    public static void main(String[] args) throws IOException {
        String msgBody = "{\n" +
                "  \"brandCode\": \"250\",\n" +
                "  \"classCode\": \"A6\",\n" +
                "  \"detail\": [\n" +
                "    {\n" +
                "      \"amount\": 1980.0000,\n" +
                "      \"brandCode\": \"250\",\n" +
                "      \"classCode\": \"A6\",\n" +
                "      \"payCode\": \"33\",\n" +
                "      \"bankAccount\": \"bankAccount\",\n" +
                "      \"bankName\": \"bankName\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"amount\": \"-1980.0000\",\n" +
                "      \"brandCode\": \"250\",\n" +
                "      \"classCode\": \"A6\",\n" +
                "      \"payCode\": \"13\",\n" +
                "      \"bankName\": \"null\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"isLockBalanceFlag\": 1,\n" +
                "  \"isRushReceivable\": 0,\n" +
                "  \"memberCode\": \"htd20315984\",\n" +
                "  \"operaterCode\": \"TNO10000\",\n" +
                "  \"operaterName\": \"TINA\",\n" +
                "  \"productCode\": \"bankPayOnline\"\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        BalanceMessage balanceMessage = mapper.readValue(msgBody, BalanceMessage.class);

        String detail =  mapper.writeValueAsString(balanceMessage.getDetail());

        System.out.println(detail);
    }

    public static class BalanceMessage {
        private String rechargeOrderNo;
        private String operaterCode;
        private String operaterName;
        private String salemanCode;
        private String saleman;
        private String departmentCode;
        private String memberCode;
        private String productCode;
        private String isRushReceivable;
        private String remarks;
        private String isLockBalanceFlag;
        private String brandCode;
        private String classCode;
        private String supplierCode;
        private List<Map<String, Object>> detail;

        public BalanceMessage() {
        }

        public String getOperaterCode() {
            return this.operaterCode;
        }

        public void setOperaterCode(String operaterCode) {
            this.operaterCode = operaterCode;
        }

        public String getOperaterName() {
            return this.operaterName;
        }

        public void setOperaterName(String operaterName) {
            this.operaterName = operaterName;
        }

        public String getSalemanCode() {
            return this.salemanCode;
        }

        public void setSalemanCode(String salemanCode) {
            this.salemanCode = salemanCode;
        }

        public String getSaleman() {
            return this.saleman;
        }

        public void setSaleman(String saleman) {
            this.saleman = saleman;
        }

        public String getDepartmentCode() {
            return this.departmentCode;
        }

        public void setDepartmentCode(String departmentCode) {
            this.departmentCode = departmentCode;
        }

        public String getMemberCode() {
            return this.memberCode;
        }

        public void setMemberCode(String memberCode) {
            this.memberCode = memberCode;
        }

        public String getProductCode() {
            return this.productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public String getIsRushReceivable() {
            return this.isRushReceivable;
        }

        public void setIsRushReceivable(String isRushReceivable) {
            this.isRushReceivable = isRushReceivable;
        }

        public String getRemarks() {
            return this.remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public List<Map<String, Object>> getDetail() {
            return this.detail;
        }

        public void setDetail(List<Map<String, Object>> detail) {
            this.detail = detail;
        }

        public String getRechargeOrderNo() {
            return this.rechargeOrderNo;
        }

        public void setRechargeOrderNo(String rechargeOrderNo) {
            this.rechargeOrderNo = rechargeOrderNo;
        }

        public String getIsLockBalanceFlag() {
            return this.isLockBalanceFlag;
        }

        public void setIsLockBalanceFlag(String isLockBalanceFlag) {
            this.isLockBalanceFlag = isLockBalanceFlag;
        }

        public String getBrandCode() {
            return this.brandCode;
        }

        public void setBrandCode(String brandCode) {
            this.brandCode = brandCode;
        }

        public String getClassCode() {
            return this.classCode;
        }

        public void setClassCode(String classCode) {
            this.classCode = classCode;
        }

        public String getSupplierCode() {
            return this.supplierCode;
        }

        public void setSupplierCode(String supplierCode) {
            this.supplierCode = supplierCode;
        }
    }
}
