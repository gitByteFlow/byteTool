# nfc

[谷歌官网NFC基础知识](https://developer.android.google.cn/guide/topics/connectivity/nfc/nfc.html)  
[谷歌官网NFC进阶知识](https://developer.android.google.cn/guide/topics/connectivity/nfc/advanced-nfc.html)  
[谷歌官网NFC卡模拟](https://developer.android.google.cn/guide/topics/connectivity/nfc/hce.html)



## 卡片
![image](https://user-images.githubusercontent.com/13781081/138247722-7a077c1b-3d17-401f-94be-ec9920380245.png)

### M1卡
每张IC卡都有16个扇区，包括1个公共区和15个数据区。每个扇区有4个块，每个块占16字节。

第0扇区的块0为厂商代码，已经固化。包括芯片序列号UID，ATQA和SAK

每个扇区的块3为控制块，用来存放密码和控制权限 ，不能用来存储数据。

每个扇区的块0，块1，块2可以用来存储数据（扇区0的块0除外）。

块3的前6个字节为KeyA，后6个字节为KeyB。中间的4个字节为存储控制

非加密卡和加密卡的区别就是，非加密卡中所有扇区的KEYA和KEYB数值都是默认值FFFFFFFFFFFF；而加密卡中，其中有扇区的KEYA和KEYB不等于FFFFFFFFFFFF，部分扇区加密的卡称半加密卡，所有扇区都加密的卡称全加密卡

![image](https://user-images.githubusercontent.com/13781081/138247944-fc684fd6-9c17-4723-8554-80ba3c890108.png)

### 读卡器与上位机通信机制

![image](https://user-images.githubusercontent.com/13781081/138248126-cdd0eb28-9c8a-4471-9cea-0b6bdbf99e24.png)






