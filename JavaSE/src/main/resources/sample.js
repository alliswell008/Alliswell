// Nashorn JavaScript引擎
// 若要执行，打开控制台(在windows下定位到jdk/bin目录下)，输入以下命令：jjs sample.js

var BigDecimal = Java.type('java.math.BigDecimal');

function calculate(amount, percentage) {

    var result = new BigDecimal(amount).multiply(
        new BigDecimal(percentage)).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_EVEN);

    return result.toPlainString();
}

var result = calculate(568000000000000000023,13.9);
print(result);