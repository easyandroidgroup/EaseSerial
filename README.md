# Serial串口依赖库及demo
Android主板串口依赖库,kotlin书写
 lastVersion =
依赖方式如下：
###1.添加maven地址到你的依赖仓库
#####
 allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
###2.添加依赖
    	dependencies {
    	        implementation 'com.github.easyandroidgroup:serial:${lastVersion}'
    	}