reference : https://roytuts.com/declarative-transaction-management-example-in-spring/


Transactional Annotation
This @Transactional annotation is for declarative transaction management in Spring application.

You can put put @Transactional annotation at class level or at method level.
If you put @Transactional annotation at class level then it wraps all the method in a transaction scope.
If you put @Transactional annotation at method level then it works with the particular method on which it is applied.

You can also put @Transactional annotation at class and method levels at the same time and in this case @Transactional
annotation will be applied for all the methods with similar behavior except the methods for which you have applied
@Transactional annotation at method level will have different behavior.

@Transactional annotation has several properties such as readOnly, isolation, propagation, rollbackFor, noRollbackFor etc.
These properties can be used to control the behavior and communication with other transactions.

You can use @Transactional(readOnly=true) for select queries and @Transactional for insert and update queries because by
default readOnly=false. And for reading data you don’t need to use transaction as there is no chance of overwriting data.

Another two important properties are rollbackFor and noRollbackFor – used for if a class throws exception the transaction
will be rolled back for that exception class and rollback will not happen for that exception class respectively.

I have written deleteItem() to throw an Exception so that I can show you how the data is rolled back on Exception.