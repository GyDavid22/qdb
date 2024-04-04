export interface QuestionMetadata {
    id: number,
    title: string,
    tags: string[],
    imagesUrls: string[],
    createdby: string,
    isReported: boolean,
    currentUserHasEditingRights: boolean;
}
