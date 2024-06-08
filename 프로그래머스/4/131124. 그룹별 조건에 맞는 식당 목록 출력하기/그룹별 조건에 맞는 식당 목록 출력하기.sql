SELECT
    mp.MEMBER_NAME,
    rv.REVIEW_TEXT,
    DATE_FORMAT(rv.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
FROM
    MEMBER_PROFILE mp
    INNER JOIN REST_REVIEW rv ON mp.MEMBER_ID = rv.MEMBER_ID
WHERE
    mp.MEMBER_ID = (
        SELECT
            MEMBER_ID
        FROM
            REST_REVIEW
        GROUP BY
            MEMBER_ID
        ORDER BY
            COUNT(*) DESC
        LIMIT 1
    )
ORDER BY
    rv.REVIEW_DATE ASC,
    rv.REVIEW_TEXT ASC;
