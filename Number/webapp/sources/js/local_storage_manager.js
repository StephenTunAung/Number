window.fakeStorage = {
	_data : {},

	setItem : function(id, val) {
		return this._data[id] = String(val);
	},

	getItem : function(id) {
		return this._data.hasOwnProperty(id) ? this._data[id] : undefined;
	},

	removeItem : function(id) {
		return delete this._data[id];
	},

	clear : function() {
		return this._data = {};
	}
};

function LocalStorageManager() {
	this.bestScoreKey = "bestScore";
	this.gameStateKey = "gameState";

	var supported = this.localStorageSupported();
	this.storage = supported ? window.localStorage : window.fakeStorage;
}

LocalStorageManager.prototype.localStorageSupported = function() {
	var testKey = "test";
	var storage = window.localStorage;

	try {
		storage.setItem(testKey, "1");
		storage.removeItem(testKey);
		return true;
	} catch (error) {
		return false;
	}
};

// Best score getters/setters
LocalStorageManager.prototype.getBestScore = function() {

	return this.storage.getItem(this.bestScoreKey) || 0;

};

LocalStorageManager.prototype.setBestScore = function(score) {

		this.storage.setItem(this.bestScoreKey, score);
		var myBestScore = this.storage.getItem(this.bestScoreKey) || 0;
		

		if (window.XMLHttpRequest) { // for IE7+, Firefox, Chrome, Opera, Safari
			request = new XMLHttpRequest();
		} else { // IE 6 and 5
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		request.open("GET",
				"http://localhost:8080/Number/app/sendBestScore?userId="
						+ userId + "&bestScore=" + myBestScore, true);
		request.send();
		

};

// Game state getters/setters and clearing
LocalStorageManager.prototype.getGameState = function() {
	var stateJSON = this.storage.getItem(this.gameStateKey);
	return stateJSON ? JSON.parse(stateJSON) : null;
};

LocalStorageManager.prototype.setGameState = function(gameState) {
	this.storage.setItem(this.gameStateKey, JSON.stringify(gameState));
};

LocalStorageManager.prototype.clearGameState = function() {
	this.storage.removeItem(this.gameStateKey);
};
