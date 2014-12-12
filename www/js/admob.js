angular.module('shoppinglist.admob', [])
.service('AdMob', function() {
	document.addEventListener('onAdLoaded',function(data){
	    AdMob.showBanner(2);
	});
	 ionic.Platform.ready(function() {
		// Initialize ad
	   	//var admobParam = new  admob.Params();
	    //admobParam.extra = {'keyword':"shoppinglist"};
	   	//admob.initAdmob("ca-app-pub-8347180568592241/3644354994","ca-app-pub-8347180568592241/5121088199");
	   	//admob.showBanner(admob.BannerSize.BANNER,admob.Position.BOTTOM_CENTER);
		 
		 
		 var ad_units = {
		    ios : {
		    	banner: 'ca-app-pub-8347180568592241/3644354994',
		        interstitial: 'ca-app-pub-8347180568592241/5121088199'
		    },
		    android : {
		    	banner: 'ca-app-pub-8347180568592241/3644354994',
		        interstitial: 'ca-app-pub-8347180568592241/5121088199'
		    }
		};
		 
		 var admobid = ( /(android)/i.test(navigator.userAgent) ) ? ad_units.android : ad_units.ios;
		 
		 
			AdMob.createBanner({
			    adId:admobid.banner,
			    position:AdMob.AD_POSITION.TOP_CENTER, 
			    autoShow:true
			});
		 
//		 AdMob.createBanner({
//			   adId: admobid.banner,
//			   position: AdMob.AD_POSITION.BOTTOM_CENTER,
//			   autoShow: false,
//			   isTesting: true
//		 });
		 
		 AdMob.prepareInterstitial({
		    adId: admobid.interstitial,
		    autoShow: false
		 });
		 
		 
	 });
});