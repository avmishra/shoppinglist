angular.module('shoppinglist.admob', [])
.service('AdMob', function() {
	 ionic.Platform.ready(function() {
		// Initialize ad
	   	var ad_units = {
		    ios: {
		    	banner: 'ca-app-pub-8347180568592241/3644354994',
		        interstitial: 'ca-app-pub-8347180568592241/5121088199'
		    },
		    android: {
		    	banner: 'ca-app-pub-8347180568592241/3644354994',
		        interstitial: 'ca-app-pub-8347180568592241/5121088199'
		    }
		};
		 
		 var admobid = ( /(android)/i.test(navigator.userAgent) ) ? ad_units.android : ad_units.ios;
		 AdMob.createBanner({
			 adId:admobid.banner,
			 autoShow:false
		 });
		
		 document.addEventListener('onAdLoaded',function(data){
			 console.log("====="+device.version);
		    if (device.version.search('4.1') !== 0) {
		    	AdMob.showBanner(9);
		    }
		 });
		 
		 
	 });
});