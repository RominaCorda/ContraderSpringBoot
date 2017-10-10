<#include "header.ftl">
<#include "topbar.ftl">

<br>

<div class="row columns">
    <div class="row">
        <h3>Search for Reports</h3>
    </div>

    <div class="row">
        <form>
            <div class="grid-container">
                <div class="grid-x grid-padding-x">
                    <div class="medium-6 cell">
                        <label>Report
                            <input type="text" placeholder="Report name contains...">
                        </label>
                    </div>
                    <div class="medium-6 cell">
                        <label>Select Menu
                            <select>
                                <option value="husker">Husker</option>
                                <option value="starbuck">Starbuck</option>
                                <option value="hotdog">Hot Dog</option>
                                <option value="apollo">Apollo</option>
                            </select>
                        </label>
                    </div>
                </div>
            </div>
        </form>
    </div>


</div>


<#include "footer.ftl">
<#include "foundation.ftl">

</body>
</html>

