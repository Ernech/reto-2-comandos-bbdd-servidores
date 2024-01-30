#Reto 2: Comandos para servidores y bases de datos
##To execute this project
1. Download the project
2. Set your Api key in the <b>Constants</b> class
```
package resources;

public class Constants {

    public static final String BASE_GOOGLE_SCHOLAR_URL = "https://serpapi.com/";
    public static final String API_KEY = "MY_API_KEY"; <-- Your api key
    public static final String GOOGLE_SCHOLAR_ENGINE="google_scholar";
    public static final String GOOGLE_SCHOLAR_AUTHOR_ENGINE="google_scholar_author";
}

```
# Google Scholar API

Our Google Scholar API allows you to scrape SERP results from a Google Scholar search query. The API is accessed through the following endpoint: ```/search?engine=google_scholar```.

A user may query the following: ```https://serpapi.com/search?engine=google_scholar``` utilizing a GET request. Head to the [playground](https://serpapi.com/playground?engine=google_scholar) for a live and interactive demo.

## Api parameters

>Search query


<table>
    <tr>
        <td>q</td>
        <td>Required</td>
        <td>
            <p>Parameter defines the query you want to search. You can also use helpers in your query such as: <b>author:</b>, or <b>source:</b>.</p>
            <p> Usage of <b>cites</b> parameter makes <b>q</b> optional. Usage of <b>cites</b> together with <b>q</b> triggers search within citing articles.</p>
            <p>Usage of <b>cluster</b> together with <b>q</b> and <b>cites </b> parameters is prohibited. Use <b>cluster</b> parameter only.</p>
        </td>
    </tr>
</table>

> Advanced Google Scholar Parameters

<table>
    <tr>
        <td>cities</td>
        <td>Optional</td>
        <td>
            <p>Parameter defines unique ID for an article to trigger <b>Cited By</b> searches. Usage of <b>cites</b> will bring up a list of citing documents in Google Scholar. Example value: <b>cites=1275980731835430123</b>. Usage of <b>cites</b> and <b>q</b> parameters triggers search within citing articles.</p>
        </td>
    </tr>
    <tr>
        <td>as_ylo</td>
        <td>Optional</td>
        <td>
            <p> Parameter defines the year from which you want the results to be included. (e.g. if you set <b>as_ylo</b> parameter to the year <b>2018</b>, the results before that year will be omitted.). This parameter can be combined with the <b>as_yhi</b> parameter.</p>
        </td>
    </tr>
    <tr>
        <td>as_yhi</td>
        <td>Optional</td>
        <td>
            <p> Parameter defines the year from which you want the results to be included. (e.g. if you set <b>as_yhi</b> parameter to the year <b>2018</b>, the results before that year will be omitted.). This parameter can be combined with the <b>as_ylo</b> parameter.</p>
        </td>
    </tr>
    <tr>
        <td>as_ylo</td>
        <td>Optional</td>
        <td>
            <p> Parameter defines the year from which you want the results to be included. (e.g. if you set <b>as_ylo</b> parameter to the year <b>2018</b>, the results before that year will be omitted.). This parameter can be combined with the <b>as_yhi</b> parameter.</p>
        </td>
    </tr>
    <tr>
        <td>scisbd</td>
        <td>Optional</td>
        <td>
            <p>Parameter defines articles added in the last year, sorted by date. It can be set to <b>1</b> to include only abstracts, or <b>2</b> to include everything. The default value is <b>0</b> which means that the articles are sorted by relevance.</p>
        </td>
    </tr>
</table>

>Localization


<table>
    <tr>
        <td>hl</td>
        <td>Optional</td>
        <td>
            <p>Parameter defines the language to use for the Google Scholar search. It's a two-letter language code. (e.g., <b>en</b> for English, <b>es</b> for Spanish, or <b>fr</b> for French). Head to the <a href="https://serpapi.com/google-languages">Google languages page</a> for a full list of supported Google languages.</p>
        </td>
    </tr>
    <tr>
        <td>lr</td>
        <td>Optional</td>
        <td>
            <p>Parameter defines one or multiple languages to limit the search to. It uses <b>lang_{two-letter language code}</b> to specify languages and <b>|</b> as a delimiter. (e.g., <b>lang_fr|lang_de</b> will only search French and German pages). Head to the <a href="https://serpapi.com/google-lr-languages">Google lr languages</a> for a full list of supported languages.</p>
        </td>
    </tr>
</table>

> Pagination

<table>
    <tr>
        <td>start</td>
        <td>Optional</td>
        <td>
            <p>Parameter defines the result offset. It skips the given number of results. It's used for pagination. (e.g., <b>0</b> (default) is the first page of results, <b>10</b> is the 2nd page of results, <b>20</b> is the 3rd page of results, etc.).</p>
        </td>
    </tr>
    <tr>
        <td>num</td>
        <td>Optional</td>
        <td>
            <p>Parameter defines one or multiple languages to limit the search to. It uses <b>lang_{two-letter language code}</b> to specify languages and <b>|</b> as a delimiter. (e.g., <b>lang_fr|lang_de</b> will only search French and German pages). Head to the <a href="https://serpapi.com/google-lr-languages">Google lr languages</a> for a full list of supported languages.</p>
        </td>
    </tr>
</table>

>Search type

<table>
    <tr>
        <td>as_sdt</td>
        <td>Optional</td>
        <td>
        <p>Parameter can be used either as a search type or a filter.</p>
        <p>
            <b>As a Filter</b> (only works when searching articles):
            <ul>
            <li>
                <b>0</b> - exclude patents (default).
            </li>
            <li>
                <b>7</b> - include patents.
            </li>
            </ul>
        </p>
        <p>
        <p><b>As a Search Type:</b></p>
        <b>4</b> - Select case law (US courts only). This will select all the State and Federal courts.
        e.g. <b>as_sdt=4</b> - Selects case law (all courts)
        </p>
        <p>
            To select specific courts, see the full list of supported <a href="https://serpapi.com/google-scholar-courts">Google Scholar courts</a>.
            e.g. <b>as_sdt=4,33,192 - 4</b> is the <b>required</b> value and should always be in the first position, <b>33</b> selects all New York courts and <b>192</b> selects Tax Court.
            Values have to be separated by comma (<b>,</b>)
        </p>
        </td>
    </tr>
</table>

>Advanced Filters

<table>
    <tr>
        <td>safe</td>
        <td>Optional</td>
        <td>
            <p>Parameter defines the level of filtering for adult content. It can be set to <b>active</b> or <b>off</b>, by default Google will blur explicit content.</p>
        </td>
    </tr>
    <tr>
        <td>filter</td>
        <td>Optional</td>
        <td>
            <p>Parameter defines if the filters for 'Similar Results' and 'Omitted Results' are on or off. It can be set to <b>1</b> (default) to enable these filters, or <b>0</b> to disable these filters.</p>
        </td>
    </tr>
    <tr>
        <td>as_vis</td>
        <td>Optional</td>
        <td>
            <p>Parameter defines whether you would like to include citations or not. It can be set to <b>1</b> to exclude these results, or <b>0</b> (default) to include them.</p>
        </td>
    </tr>
    <tr>
        <td>as_rr</td>
        <td>Optional</td>
        <td>
            <p>Parameter defines whether you would like to show only review articles or not (these articles consist of topic reviews, or discuss the works or authors you have searched for). It can be set to <b>1</b> to enable this filter, or <b>0</b> (default) to show all results.</p>
        </td>
    </tr>
</table>

>Serpapi Parameters

<table>
    <tr>
        <td>engine</td>
        <td>Required</td>
        <td>
            <p>Set parameter to <b>google_scholar</b> to use the Google Scholar API engine.</p>
        </td>
    </tr>
    <tr>
        <td>no_cache</td>
        <td>Optional</td>
        <td>
            <p>Parameter will force SerpApi to fetch the Google Scholar results even if a cached version is already present. A cache is served only if the query and all parameters are exactly the same. Cache expires after 1h. Cached searches are free, and are not counted towards your searches per month. It can be set to <b>false</b> (default) to allow results from the cache, or <b>true</b> to disallow results from the cache. <b>no_cache</b> and <b>async</b> parameters should not be used together.</p>
        </td>
    </tr>
    <tr>
        <td>async</td>
        <td>Optional</td>
        <td>
            <p>Parameter defines the way you want to submit your search to SerpApi. It can be set to <b>false</b> (default) to open an HTTP connection and keep it open until you got your search results, or <b>true</b> to just submit your search to SerpApi and retrieve them later. In this case, you'll need to use our <a href="https://serpapi.com/search-archive-api">Searches Archive API</a> to retrieve your results. <b>async</b> and <b>no_cache</b> parameters should not be used together. <b>async</b> should not be used on accounts with <a href="https://serpapi.com/users/sign_in">Ludicrous Speed</a> enabled.</p>
        </td>
    </tr>
    <tr>
        <td>api_key</td>
        <td>Required</td>
        <td>
            <p>Parameter defines the SerpApi private key to use.</p>
        </td>
    </tr>
    <tr>
        <td>output</td>
        <td>Required</td>
        <td>
            <p>Parameter defines the final output you want. It can be set to json (default) to get a structured <b>JSON</b> of the results, or <b>html</b> to get the raw html retrieved.</p>
        </td>
    </tr>
</table>

## Api results

>Json results

JSON output includes structured data for [organic results](https://serpapi.com/google-scholar-organic-results).

A search status is accessible through ```search_metadata.status.``` It flows this way: ```Processing -> Success || Error```. If a search has failed, ```error``` will contain an error message. ```search_metadata.id``` is the search ID inside SerpApi.

> Html examples

HTML output is useful to debug JSON results or support features not supported yet by SerpApi.
HTML output gives you the raw HTML results from Google.

> API Examples

Example with **q**: ```biology```

</> **GET**:
https://serpapi.com/search.json?engine=google_scholar&q=biology

</> **Code Integrate**

```
Map<String, String> parameter = new HashMap<>();

parameter.put("engine", "google_scholar");
parameter.put("q", "biology");
parameter.put("api_key", "secret_api_key");

GoogleSearch search = new GoogleSearch(parameter);

try
{
  JsonObject results = search.getJson();
  var organic_results = results.get("organic_results");
}
catch (SerpApiClientException ex)
{
  Console.WriteLine("Exception:");
  Console.WriteLine(ex.ToString());
}
```