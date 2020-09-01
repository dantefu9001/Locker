1. given 一个robot，一个freeCapacity=10的locker
when robot存包
then 返回票据，包存在locker中

2. given 一个robot，两个locker，第一个freeCapacity=10， 第二个freeCapacity=10
when robot存包
then 返回票据，包存在第一个locker中

3. given 一个robot，两个locker，第一个freeCapacity=0， 第二个freeCapacity=10
when robot存包
then 返回票据，包存在第二个locker中

4. given 一个robot，两个locker，有效票ticket
when robot取包
then 返回包

5. given 一个robot，两个locker，伪造无效票ticket
when robot取包
then 票据无效

6. given 一个robot，两个locker，已经取过包的ticket
when robot取包
then 票据无效
