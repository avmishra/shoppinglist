var login = {
    // Application Constructor
    initialize: function() {
        this.bindEvents();
    },
    // Bind Event Listeners
    // Bind any events that are required on startup. Common events are:
    // 'load', 'deviceready', 'offline', and 'online'.
    bindEvents: function() {
        document.addEventListener('deviceready', this.onDeviceReady, false);
    },
    onDeviceReady: function() {
    	//alert('beforesubmit');
    	//$("#frmlogin").submit(this.onSubmit);
    },
    onSubmit: function () {
    	alert("test");
//    	$.ajax({
//			type:'POST',
//			dataType:'jsonp',
//			jsonp:'jsonp',
//			//url:'http://api.stackoverflow.com/1.0/tags/',
//			url:'http://localhost/test.php',
//			success:function(data) {
//				console.log("done");
//			},
//			error:function() {
//				alert("Sorry, I can't get the feed");	
//			}
//		});
    }
};

login.initialize();

function validation() {
	alert('tet');
}


