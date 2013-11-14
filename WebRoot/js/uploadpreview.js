$(document).ready(function() {
	var result = document.getElementById("imgDiv");
	var input = document.getElementById("upload");
	if (typeof FileReader === 'undefined') {
		result.innerHTML = "Sorry";
	} else {
		$("#upload").change(function() {
			var file = this.files[0];
			if (!/image\/\w+/.test(file.type)) {
				alert("需要图片！");
				return;
			}
			var reader = new FileReader();
			reader.readAsDataURL(file);
			reader.onload = function(e) {
				result.innerHTML = '<img src="' + this.result + '" alt=""/>';
			};
		});
	}
});