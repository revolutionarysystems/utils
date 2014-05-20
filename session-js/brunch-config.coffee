exports.config =
	paths:
		public: "dist"
		watched: ["src", "test", "haven_artifacts"]
	files:
		javascripts:
			joinTo: 
				'app.js': /^(src|haven_artifacts(\\|\/)compile)/
	modules:
		wrapper: false
		definition: false
