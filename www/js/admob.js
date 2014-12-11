angular.module('shoppinglist.admob', [])
.service('AdMob', function() {
	 ionic.Platform.ready(function() {
		// Initialize ad
	   	var admobParam = new  admob.Params();
	    admobParam.extra = {'keyword':"shoppinglist"};
	   	admob.initAdmob("ca-app-pub-8347180568592241/3644354994","ca-app-pub-8347180568592241/5121088199");
	   	admob.showBanner(admob.BannerSize.BANNER,admob.Position.BOTTOM_CENTER);
	 });
});