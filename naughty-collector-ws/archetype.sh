#!/bin/bash
#
# Title:archetype.sh
#
# Description:
#
# Development Environment:
#   OS X 10.8.5
#
# Legalise:  
#   Copyright (C) 2014 Digital Burro, INC.
#
# Author:
#   G.S. Cole (guycole at gmail dot com)
#
# Maintenance History:
#   $Id$
#
#   $Log$
#
#PATH=/bin:/usr/bin:/etc:/usr/local/bin; export PATH
#
mvn archetype:generate -B -DarchetypeArtifactId=guestbook-archetype -DarchetypeGroupId=com.google.appengine.archetypes -DarchetypeVersion=1.8.4 -DgroupId=com.digiburo.gae.demo -DartifactId=gae-java-demo -Dversion=1.0-SNAPSHOT
#
