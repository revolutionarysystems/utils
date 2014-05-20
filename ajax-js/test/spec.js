describe("Ajax", function() {
	var url = "http://httpbin.org";
	describe("#get()", function() {
		it("should send a HTTP GET request to the endpoint and return a string", function(done) {
			Ajax.get(url + "/get", {
				onSuccess: function(response) {
					done();
				}
			});
		});
		it("should send a HTTP GET request to the endpoint and return an object", function(done) {
			Ajax.get(url + "/get", {
				responseType: "json",
				onSuccess: function(response) {
					expect(typeof response === "object").toBe(true);
					done();
				}
			});
		});
	});
	describe("#getJSON()", function() {
		it("should send a HTTP GET request to the endpoint and return an object", function(done) {
			Ajax.getJSON(url + "/get", {
				onSuccess: function(response) {
					expect(typeof response === "object").toBe(true);
					done();
				}
			});
		});
	});
	describe("#post()", function() {
		it("should send a HTTP POST request with the given data", function(done) {
			Ajax.post(url + "/post", "param1=value1", {
				responseType: "json",
				onSuccess: function(response) {
					expect(response.form.param1).toBe("value1");
					done();
				}
			});
		});
	});
});