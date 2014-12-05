
angular.module('shoppinglist.admob', [])
.service('AdMob', function() {
	 ionic.Platform.ready(function() {
		// Initialize ad
	   	var admobParam = new  admob.Params();
	    admobParam.extra = {'keyword':"shoppinglist"};
	   	admob.initAdmob("ca-app-pub-xxx","ca-app-pub-xxx");
	   	admob.showBanner(admob.BannerSize.BANNER,admob.Position.BOTTOM_CENTER);
	 });
});