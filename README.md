# JavaMediaPlayer
A desktop version simple media player using JavaFX,cross platform

中文README文档看这里:https://github.com/JiaDingCN/JavaMediaPlayer/blob/master/README_Chinese

This project is based on https://github.com/Al-assad/Simple-Media-Player .Thanks the author.

## Funtions

Play the local mp4 media file:

![本地视频播放](https://user-images.githubusercontent.com/36098426/75112628-968f5580-5680-11ea-9d90-b7e0b68976a4.png)

Play the online video(URL is needed):

![在线视频播放](https://user-images.githubusercontent.com/36098426/75112629-97c08280-5680-11ea-9cc9-2d4c0a8d3e6c.png)

Other functions:

* All basic functions for a media player:Play/Pause/Stop/FullWindow/Control volume
* Save and read the file of online media URL list

## Introduction

Based on Oracle JDK1.8 and JavaFX.Using the MediaPlayer in JavaFX to play media.

Supported media types:

* Mp3 
* AIFF with non-compressed PCM
* WAV with non-compressed  PCM
* MPEG-4 with AAC
* FLV(VP6 video and MP3 audio)
* MPEG-4 using H.264 or AVC
* Usually used online media type

## Problems havn't solved

* progress bar can't be dragged to control the player
* Played media will still take up the memory until the program is terminated.
* ButtonBar won't disappear automatically when full-window model is used

