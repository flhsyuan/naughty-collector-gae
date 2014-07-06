#!/bin/bash
#
# Title:diagnostic.sh
#
# Description:post to diagnostic lotto
#
# Development Environment:OS X 10.8.5
#
# Legalise:Copyright (C) 2014 Digital Burro, INC.
#
# Author:G.S. Cole (guycole at gmail dot com)
#
curl -v -H "Content-Type:application/json" -d '{"locationList":[{"accuracy":1.11,"altitude":2.22,"latitude":3.33,"longitude":4.44,"timeStampMs":1400369190000,"locationId":"ijkl"},{"accuracy":1.11,"altitude":2.22,"latitude":3.33,"longitude":4.44,"timeStampMs":1400373877000,"locationId":"ijkl"}],"installationId":"abcd","sortieId":"efgh","messageVersion":1}' https://mellow-heeler.appspot.com/diagnostic
#
