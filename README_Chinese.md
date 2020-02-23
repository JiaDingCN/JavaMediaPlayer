# 使用javafx实现视频播放器

本项目是基于项目https://github.com/Al-assad/Simple-Media-Player进行修改的，向原作者的工作致敬
## 功能介绍
![本地视频播放](blob:http://markdown.xiaoshujiang.com/c63c1f80-8323-4875-bc9b-274752f512ce)
![在线视频播放](blob:http://markdown.xiaoshujiang.com/75682adf-2e82-419b-9053-9d6cce56a886)

## 项目介绍
基于Oracle JDK1.8 ,使用JavaFX开发，调用JavaFX 内置的MediaPlayer播放使用。
主要功能:
* 播放器常用功能：开始/暂停/全屏/控制音量
* 播放本地视频
* 播放在线视频（需获得视频播放地址）
* 播放直播（需获得直播源URL）
* 读取和保存在线视频和直播URL列表

支持的多媒体格式：
因为是直接调用MediaPlayer，所以支持的多媒体格式有限：
音频
* MP3；
* 包含非压缩PCM的AIFF；
* 包含非压缩PCM的WAV；
* 使用AAC音频的MPEG-4;

视频
* 包含VP6视频和MP3音频的FLV；
* 使用H.264/AVC视频压缩的MPEG-4;
* 常见网络视频及直播源（需要提供直链）

## 目前存在的问题
1. 未实现进度条的拖动（参考的原项目实现了，有需要的可以去看原项目中的实现）
2. 在软件关闭之前播放的视频会一直占用内存
3. 未实现全屏时buttonbar的自动隐藏
