import { Author } from './author';
import { Category } from './category';

export class Ebook {
    private id: string;
    private title: string;
    private description: string;
    private cover: any;
    private author: Author;
    private category: Category;
    private stock: string;

}