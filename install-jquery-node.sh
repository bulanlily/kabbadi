#!/bin/bash
brew install nodejs
curl http://npmjs.org/install.sh | sh 
npm install -g jasmine-node && npm install jsdom jasmine-jquery jquery
