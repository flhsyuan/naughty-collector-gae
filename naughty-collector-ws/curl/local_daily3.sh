#!/bin/bash
#
# Title:local_daily3.sh
#
# Description:naughty collector daily3 test
#
# Development Environment:OS X 10.8.5
#
# Legalise:Copyright (C) 2014 Digital Burro, INC.
#
# Author:G.S. Cole (guycole at gmail dot com)
#
#curl -v -H "Content-Type:application/json" -d '{"installationId":"51906849-d546-4358-ac5c-66936323e7e9"}' http://127.0.0.1:8080/ws/lotto/v1/daily3
#
curl -v http://127.0.0.1:8080/ws/lotto/v1/daily3
#