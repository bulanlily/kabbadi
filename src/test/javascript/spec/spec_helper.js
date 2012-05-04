global.window = require("jsdom").jsdom().createWindow();

global.jQuery = require('jquery');
global.$ = jQuery
require('jasmine-jquery');
require('../../../main/javascript/asset/edit.js')
require('../../../main/javascript/jquery.validate.min.js')
global.kabbadi = window.kabbadi