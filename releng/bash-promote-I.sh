#!/bin/bash
PROMO_LOGS_DIR="/home/data/users/sbouchet/promo_logs"
RELENG_DIR="/opt/users/hudsonbuild/.hudson/jobs/cbi-emf-eef-0.7-integration/workspace/org.eclipse.emf/org.eclipse.emf.eef/releng"
ANT="/opt/public/common/apache-ant-1.7.1/bin/ant"
logFile="/home/data/users/sbouchet/cronLog.txt"

rm -f $logFile
touch $logFile
echo "[`date +%Y/%m/%d\ %H:%M`]: publishing integration build ..." >> $logFile
mkdir -p $PROMO_LOGS_DIR
$ANT -f $RELENG_DIR/promote.xml -Dpromote.properties=$RELENG_DIR/promote-I.properties 2>/dev/null 1> $PROMO_LOGS_DIR/cbi-emf-eef-promo-I.txt
