-- +---------------+---------+
-- | 열 이름       | 타입    |
-- +---------------+---------+
-- | user_id       | int     |
-- | session_id    | int     |
-- | activity_date | date    |
-- | activity_type | enum    |
-- +---------------+---------+
--
-- 이 테이블에는 중복된 행이 있을 수 있습니다.
-- activity_type 열은 ('open_session', 'end_session', 'scroll_down', 'send_message') 타입의 ENUM(카테고리)입니다.
-- 이 테이블은 소셜 미디어 웹사이트의 사용자 활동을 보여줍니다.
-- 참고로 각 세션은 정확히 한 명의 사용자에게 속합니다.
-- 2019-07-27을 포함하여 이전 30일 동안의 일일 활성 사용자 수를 찾는 솔루션을 작성하세요.
-- 사용자가 특정 날짜에 하나 이상의 활동을 했다면 그 날 활성 사용자로 간주됩니다.
-- 2019-07-27부터 30일 전까지의 기간 동안
-- 매일 몇 명의 사용자가 활동했는지 세어보는 것입니다
-- 한 사용자가 하루에 여러 활동을 했더라도 한 번만 카운트됩니다

-- | user_id | session_id | activity_date | activity_type |
-- | ------- | ---------- | ------------- | ------------- |
-- | 93      | 50         | 2019-06-17    | send_message  |
-- | 18      | 143        | 2019-07-26    | send_message  |
-- | 29      | 173        | 2019-06-13    | open_session  |
-- | 65      | 32         | 2019-06-20    | send_message  |
-- | 46      | 149        | 2019-05-30    | end_session   |

SELECT
    a.activity_date AS day,
    COUNT(DISTINCT a.user_id) AS active_users
FROM Activity AS a
WHERE a.activity_date
    BETWEEN
        DATE_ADD('2019-07-27', INTERVAL -29 DAY)
        AND
        '2019-07-27'
GROUP BY a.activity_date