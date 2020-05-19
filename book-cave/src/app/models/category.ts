import { Ebook } from './ebook';

export class Category {
    private id: number;
    private label: string;
    private ebooks: Ebook[];
    private subCategories: Category[];
    private createdAt: string;
    private updatedAt: string;
}