var MyJavaClass = Java.type('com.example.NashornShit.InvokeJavaMethodsFromJS')

var result = MyJavaClass.fun1('John Doe');
print("\nlog from JS: " + result);
//Hi there from Java, John Doe
//log from JS: greetings form Java


MyJavaClass.fun2(123)
MyJavaClass.fun2(49.99)
MyJavaClass.fun2(true)
MyJavaClass.fun2("hi there")
//class java.lang.Integer
//class java.lang.Double
//class java.lang.Boolean
//class java.lang.String

