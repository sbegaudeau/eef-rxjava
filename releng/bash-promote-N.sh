#!/bin/bash
BUILD_LOC="/home/data/users/sbouchet/tmp/"
PROMO_LOGS_DIR="/home/data/users/sbouchet/promo_logs"
RELENG_DIR="/opt/users/hudsonbuild/.hudson/jobs/cbi-emf-eef-0.7-nightly/workspace/build/org.eclipse.eef.releng"
ANT="/opt/public/common/apache-ant-1.7.1/bin/ant"
logFile="/home/data/users/sbouchet/cronLog.txt"

rm -f $logFile
echo "[`date +%Y/%m/%d\ %H:%M`]: getting last successful build" >> $logFile
mkdir -p $BUILD_LOC
rm -f $BUILD_LOC/build.zip
rm -rf $BUILD_LOC/build
cd $BUILD_LOC
wget --no-check-certificate "https://build.eclipse.org/hudson/job/cbi-emf-eef-0.7-nightly/lastSuccessfulBuild/artifact/build/athena/*zip*/build.zip" -o $logFile
if [ ! -f build.zip ]; then echo "ERROR:build.zip (from Hudson) not found" >> $logFile; exit -2; fi
unzip build.zip >> $logFile
echo "[`date +%Y/%m/%d\ %H:%M`]: publishing nightly build ..." >> $logFile
mkdir -p $PROMO_LOGS_DIR
$ANT -f $RELENG_DIR/promote.xml -Dpromote.properties=$RELENG_DIR/promote-N.properties 2>/dev/null 1> $PROMO_LOGS_DIR/cbi-emf-eef-promo-N.txt
