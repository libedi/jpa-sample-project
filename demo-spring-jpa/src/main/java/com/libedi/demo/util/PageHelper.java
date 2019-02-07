package com.libedi.demo.util;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * PageHelper class
 *
 * @author Sang-jun, Park
 * @param <T>
 * @since 2019. 01. 08
 */
@Getter
public class PageHelper<T> {

    /** 페이지 그룹 사이즈 */
    private final int groupSize;

    /** 현재 페이지 (one-based) */
    private final int currentPage;
    /** 현재 페이지 그룹의 시작 페이지 */
    private final int startPage;

    /** 현재 페이지 그룹의 마지막 페이지 */
    @Getter(value = AccessLevel.NONE)
    private final int lastPage;
    /** 총 페이지 */
    @Getter(value = AccessLevel.NONE)
    private final int totalPage;

    /** 현재 페이지 데이터 건수 */
    private final int currentCount;
    /** 전체 데이터 건수 */
    private final long totalCount;

    /** 조회된 데이터 */
    private final List<T> content;

    /**
     * PageHelper 생성자 - groupSize: 10
     * @param page
     */
    private PageHelper(final Page<T> page) {
        this(page, 10);
    }

    /**
     * PageHelper 생성자
     * @param page
     * @param groupSize
     */
    private PageHelper(final Page<T> page, final int groupSize) {
        this.groupSize = groupSize;
        this.currentPage = page.getNumber() + 1;
        this.startPage = (currentPage - 1) / groupSize + 1;
        this.lastPage = startPage + groupSize - 1;
        this.totalPage = page.getTotalPages();
        this.currentCount = page.getNumberOfElements();
        this.totalCount = page.getTotalElements();
        this.content = page.getContent();
    }

    public static <T> PageHelper<T> of(final Page<T> page) {
        return new PageHelper<T>(page);
    }

    public static <T> PageHelper<T> of(final Page<T> page, final int groupSize) {
        return new PageHelper<T>(page, groupSize);
    }

    public int getLastPage() {
        return lastPage > totalPage ? totalPage : lastPage;
    }

    public boolean hasPrevGroup() {
        return this.startPage > 1;
    }

    public boolean hasNextGroup() {
        return this.getLastPage() < this.totalPage;
    }

}
