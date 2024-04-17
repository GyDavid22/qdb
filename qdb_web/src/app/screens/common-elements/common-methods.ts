export class CommonMethods {
    private static calcNumPages(totalCount: number, pageSize: number): number {
        return Math.ceil(totalCount / pageSize);
    }

    public static pageOptions(totalCount: number, pageSize: number, pageIndex: number): number[] {
        let result = [];
        let numOfPages = CommonMethods.calcNumPages(totalCount, pageSize);
        for (let i = 1; i <= Math.min(numOfPages, 3); i++) {
            result.push(i);
        }
        for (let i = Math.max(pageIndex, 4); i <= Math.min(numOfPages, pageIndex + 2); i++) {
            if (!result.includes(i)) {
                result.push(i);
            }
        }
        for (let i = Math.max(1, numOfPages - 2); i <= numOfPages; i++) {
            if (!result.includes(i)) {
                result.push(i);
            }
        }
        result.sort((n1, n2) => n1 - n2);
        return result;
    }

    public static getPaginatingClass(pageNumber: number, pageIndex: number) {
        if (pageNumber == pageIndex + 1) {
            return "page-item active";
        }
        return "page-item";
    }
}