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


## Robot Manager
1. given 管理多个有容量的locker，多个locker robot，包，when robot manager自己存包，then按顺序存入有空间的第一个locker，给出小票
2. given 管理多个全满的locker，多个locker robot，包，when robot manager自己存包，then存包失败，提示无法存包
3. given多个locker，包，when要求primaryLockerRobot存包，then按照primaryLockerRobot的逻辑存包
4. given多个locker，包，when要求smartLockerRobot存包，then按照smartLockerRobot存包逻辑存包
取包：
5. given自己存的包，正确小票，when取包，then取包成功
6. given自己存的包，无效小票，when取包，then取包失败，提示失败信息
7. given primaryLockerRobot存的包，when取包，then按照primaryLockerRobot的取包逻辑取包
8. given smartLockerRobot存的包，when取包，then按照smartLockerRobot的取包逻辑取包
