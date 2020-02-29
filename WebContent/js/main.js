// JavaScript Document
var maxF=4;//最大帧数=多少张图片
var nowF=1;//当前帧数
var myTime;
function move(op){ //显示的帧数
	if(Number(op)){
		nowF=op;
		clearTimeout(myTime);
		}
	for(var i=1;i<=maxF;i++)
	{
			if(nowF==i)//判断当前显示的帧
			{
				document.getElementById("pic"+i).style.display="block";
			}else{ //其他的全部隐藏
				document.getElementById("pic"+i).style.display="none";
				}
	}
	nowF++;//当前帧进行改变
	if(nowF>maxF)
	{
		nowF=1;//从头开始
	}
	myTime=setTimeout("move()",2000);
	}
	function stopPlay()
	{
		clearTimeout(myTime);
	}

var speed=15; //数字越大速度越慢 
var tab=document.getElementById("demo"); 
var tab1=document.getElementById("demo1"); 
var tab2=document.getElementById("demo2"); 
tab2.innerHTML=tab1.innerHTML; 
function Marquee(){ 
if(tab2.offsetWidth-tab.scrollLeft<=0) 
tab.scrollLeft-=tab1.offsetWidth 
else{ 
tab.scrollLeft++; 
} 
} 
var MyMar=setInterval(Marquee,speed); 
tab.onmouseover=function() {clearInterval(MyMar)}; 
tab.onmouseout=function() {MyMar=setInterval(Marquee,speed)}; 

function openWin(){
		var url="userReg.html";
		open(url,"","width=1024px,height=748px")
	}
	
	function openWin1(){
		var url="userlogin.html";
		open(url,"","width=1024px,height=748px")
	}
			
			
