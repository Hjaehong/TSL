#!/bin/bash
#set -x

PS3="Please enter a number : "

# 현재 날짜로 부터 15일을 알 수 있는  함수
current() {
        cDATE=$(date "+%Y-%m-%d")
    for (( i = 1; i < 16; i++ )); do
        echo ${cDATE}, $(date -d "${cDATE}" '+%a')
        cDATE=$(date -d "${cDATE} + 1 day" '+%Y-%m-%d')
        if (( ${i} % 7 == 0 )); then
            echo "---------------------"
        fi
    done

}

# 윤년인지 검사
leap() {
    # 입력된 값에서 날짜만 추출
    year=`echo $1 | cut -c -4`
    if(( (${year}%4==0 && ${year}%100!=0) || ${year}%400==0 )); then
        return 0
    else
        return 2
    fi
}

# 입력된 값을 날짜로 변환하고 15일 까지 계산
calc() {
     kDATE=$(date -d "$1" "+%Y-%m-%d")

     for (( i = 1; i < 16; i++ )); do
         echo ${kDATE}, $(date -d "${kDATE}" '+%a')
         kDATE=$(date -d "${kDATE} + 1 day" '+%Y-%m-%d')
         if (( ${i} % 7 == 0 )); then
            echo "---------------------"
         fi
     done
}

# 원하는 날짜로 부터 15일을 알 수 있는 함수
want() {
    echo "enter the date , format 'YYYYMMDD' "
    read dREAD
    # 달, 일 추출
    month=`echo ${dREAD} | cut -c 5-6`
    day=`echo ${dREAD} | cut -c 7-8`
    # 입력값이 YYYYMMDD(8글자)인지 확인
    if [[ "$dREAD" =~ ^[0-9]{8}$ ]]; then
        # 윤년 확인 함수 호출
        leap $dREAD
        result=`echo "$?"`
        # 윤년이면 2월을 29일 까지
        if [ ${result} -eq 0 ] && [ ${month} -eq 2 ] && [ ${day} -le 29 ]; then
            calc ${dREAD}
        # 끝일이 30일인 월이 올 때
        elif [[ ${result} -eq 2 && ${month} =~ ^(04|06|09|11)$ && $day -le 30 ]]; then
            calc ${dREAD}
        elif [[ ${result} -eq 2 &&  ${month} =~ ^(01|03|05|07|08|10|12)$ && $day -le 31 ]]; then
            calc ${dREAD}
        elif [ ${result} -eq 2 ] && [ ${month} -eq 2 ] && [ ${day} -le 28 ]; then
            calc ${dREAD}
        else
            echo "입력값이 잘못됐습니다."
            echo "사용 방법은 매개변수에 '--help'를 추가하세요'"
        fi
    else
        echo "입력값이 잘못됐습니다, 날짜 형태를 확인해주세요"
        echo "사용 방법은 매개변수에 '--help'를 추가하세요'"
    fi


}

# 제일 먼저 호출되는 함수
main() {

    select i in cntDate wantDate; do
        case $i in
            cntDate)
                current
                break;;
            wantDate)
                want
                break;;
            *)
                echo "잘못된 접근, 해당 스크릡트의 도움말은 --help를 입력하세요"
                break;;
        esac
    done
}

show_help() {
    cat << EOF
    datePra에 대한 설명서 입니다.
이 스크립트는 날짜 계산을 하기 위한 스크립트 입니다.

첫번째) 현재 날짜를 구해서 15일 동안의 날짜를 구합니다
        1을 누르고 엔터를 누르면 해당 스크립트가 실행됩니다.

두번째) 원하는 날짜로 부터 15일을 계산할 수 있는 스크립트 입니다.
        2를 누르고 엔터를 누릅니다.
        날짜 형태는 'YYYYMMDD' 형태로 입력해야 합니다.
        YYYY는 연도 MM은 월 DD는 일 입니다 1~9은 01~09 형태로해야합니다.
EOF
}
if [ "$1" == "--help" ]; then
    show_help
else
    main $@
fi