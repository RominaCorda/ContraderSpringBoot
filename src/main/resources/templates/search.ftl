<#include "base.ftl">

<#macro page_body>
    <#include "topbar.ftl">
<!-- MAIN -->

<div class="row columns">
    <div class="row columns">
        <h3>Search for Reports</h3>
    </div>

    <div class="row columns">
        <form>
            <div class="row">
                <div class="small-12 medium-6 large-6 columns">
                    <label>Report
                        <input type="text" placeholder="Report name contains...">
                    </label>
                </div>
                <div class="small-12 medium-6 large-6 columns">
                    <label>Reporting Period
                        <input type="text" placeholder="Reporting period contains...">
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="small-12 medium-6 large-6 columns">
                    <label>Scope
                        <input type="text" placeholder="Scope name contains...">
                    </label>
                </div>
                <div class="small-12 medium-6 large-6 columns">
                    <label>Simulation
                        <input type="text" placeholder="Simulation name contains...">
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="small-12 medium-6 large-6 columns">
                    <label>Template
                        <input type="text" placeholder="Template name contains...">
                    </label>
                </div>
                <div class="small-12 medium-6 large-6 columns">
                    <label>Owner
                        <select>
                            <#list users as user>
                                <option name="user" id="${user}">${user}</option>
                            </#list>
                        </select>
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="small-12 medium-6 large-6 columns">
                    <label>Creation date (before)
                        <input name="creationBefore" type="date">
                    </label>
                </div>
                <div class="small-12 medium-6 large-6 columns">
                    <label>Creation date (after)
                        <input name="creationAfter" type="date">
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="small-12 medium-12 large-12 columns">
                    <fieldset>
                        <legend>Category</legend>
                        <input type="radio" name="pokemon" value="Official" id="pokemonRed"><label for="pokemonRed">Official</label>
                        <input type="radio" name="pokemon" value="Analysis" id="pokemonBlue"><label for="pokemonBlue">Analysis</label>
                        <input type="radio" name="pokemon" value="Both" id="pokemonYellow"><label for="pokemonYellow">Both</label>
                    </fieldset>
                </div>
            </div>
            <div class="row">
                <div class="small-12 medium-12 large-12 columns">
                    <a href="searchresults" class="button float-right">Search</a>
                </div>
            </div>
        </form>
    </div>

</div>


<!-- END OF MAIN -->
</#macro>

<#macro  before_end_scripts>
<script></script>
</#macro>

<@skeleton/>

