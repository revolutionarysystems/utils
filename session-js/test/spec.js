describe("SessionProvider", function() {
	it("should not load on page initialisation", function() {
		expect(window.session).toBe(undefined);
	});
	describe("#getSession", function() {
		it("should return the session object", function() {
			var sessionProvider = new SessionProvider();
			expect(sessionProvider.getSession()).not.toBe(undefined);
		});
		it("should allow cookies to be disabled", function() {
			var sessionProvider = new SessionProvider({location_cookie: null, session_cookie: null});
			expect(sessionProvider.getSession()).not.toBe(undefined);
		});
	});
});